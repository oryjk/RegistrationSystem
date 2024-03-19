<template>
  <view class="container">


    <uni-section title="最近接龙" type="line" padding>
      <uni-list :border="true">
        <view v-for="(competition, index) in competitions" :key="index" class="uni-flex uni-column">
          <!-- 自定义右侧内容 -->
          <uni-list-chat :title="competition.name" :avatarList="avatarList" :note="competition.gameDate"
                         badge-positon="left" :badge-text="competition.determine">
            <view class="chat-custom-container">
              <view class="chat-custom-right first">
                <text class="chat-custom-text">表态人数</text>
                <text class="chat-custom-text count">{{ competition.participated }} 人</text>
                <!-- 需要使用 uni-icons 请自行引入 -->
                <!-- <uni-icons :type="competition.signed" color="#999" size="18" @click="signIn"></uni-icons> -->

              </view>
              <view class="chat-custom-right">
                <text class="chat-custom-text">签到状态</text>
                <!-- 需要使用 uni-icons 请自行引入 -->
                <!-- <uni-icons :type="competition.signed" color="#999" size="18" @click="signIn"></uni-icons> -->
                <uni-icons :type="competition.signStatus" :color="competition.signIconColor" size="18"
                           @click="signIn(competition.id)"></uni-icons>
              </view>
            </view>

          </uni-list-chat>
          <u-line color="#2979ff"></u-line>
        </view>
      </uni-list>
    </uni-section>

    <view>
      <!-- 提示窗示例 -->
      <uni-popup ref="alertDialog" type="dialog">
        <uni-popup-dialog :type="msgType" cancelText="关闭" :confirmText="signInStatus" title="修改签到状态"
                          :content="signInContent" @confirm="dialogConfirm" @close="dialogClose"></uni-popup-dialog>
      </uni-popup>
    </view>

    <view class="example-body box">
      <!-- 提示窗示例 -->
      <uni-popup ref="noCompetitionAlertDialog" type="dialog">
        <uni-popup-dialog :type="msgType" cancelText="关闭" confirmText="好的" title="通知"
                          content="暂时还没有比赛（队长想吃扁豆味的月饼了）"></uni-popup-dialog>
      </uni-popup>
    </view>

    <button class="button" type="primary" @click="getAvatar()">获取微信头像</button>
    <img :src="avatarUrl" alt=""/>
  </view>

</template>

<script>
export default {
  data() {
    return {
      avatarUrl: "",
      loading: true,
      userId: "xxx",
      defaultCheckStatus: "checkbox",
      competitions: ['暂时没有任何接龙'],
      competitionMap: new Map(),
      userSignCompetitions: new Map(),

      msgType: 'success',

      avatarList: [{
        url: 'https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/unicloudlogo.png'
      }, {
        url: 'https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/unicloudlogo.png'
      }, {
        url: 'https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/unicloudlogo.png'
      }],
      signInStatus: "签到",
      signInContent: "",
      signInValue: 1,
      jsonHeader: {
        'content-type': 'application/json'
      },


    }
  },
  onLoad() {
    let that = this

    uni.showLoading({
      title: '加载中...', // 加载框的提示文字
      mask: true // 是否显示透明蒙层，防止触摸穿透
    });

    console.log(that.$serverHost + ':' + that.$port + "/api/competition/all")
    this.preLoadData()
  },
  methods: {

    getAvatar() {
      let that = this
      uni.getUserProfile({
        desc: '用于完善会员资料', // 声明获取用户个人信息后的用途
        success: (res) => {
          console.log('用户信息:', res.userInfo);
          that.avatarUrl = res.userInfo.avatarUrl;
          that.avatarList.push({
            url: that.avatarUrl
          })
          // 使用头像URL
        }
      });
    },

    getBaseUrl() {
      return this.$serverHost + ':' + this.$port
    },
    preLoadData() {
      let that = this
      Promise.all([that.requestAllCompetition(), that.queryUserSignCompetitions()])
          .then(([list1, list2]) => {
            console.log("xxxxx")
            if (that.competitionMap.size == 0) {
              that.$refs.noCompetitionAlertDialog.open()
            } else {
              that.competitionMap.forEach((value, key, map) => {
                let userSignCompetition = that.userSignCompetitions.get(key)
                if (userSignCompetition !== undefined) {
                  if (userSignCompetition.status == 0) {
                    that.competitionMap.get(key).signStatus = "checkbox-filled"
                    that.competitionMap.get(key).signIconColor = "#00CD00"
                  } else {
                    that.competitionMap.get(key).signStatus = "checkbox"
                    that.competitionMap.get(key).signIconColor = "#999"
                  }
                  console.log(userSignCompetition.status)
                }

              })
            }

            uni.hideLoading();
          }).catch((error) => {
        // 如果任何一个请求失败，这里的代码会执行
        console.error('An error occurred:', error);
      })
      console.log("xxxx")

      console.log("xxxxx")
    },
    fetch(url) {
      return uni.request({
        url: this.getBaseUrl() + url,
        method: 'GET'
      })
    },

    requestAllCompetition() {
      let that = this
      return that.fetch("/api/competition/all").then(result => {

        if (result.length != 2) {
          return
        }

        result[1].data.forEach(item => {
          item.signStatus = that.defaultCheckStatus
          item.signIconColor = "#999"
        })
        that.competitions = result[1].data
        that.competitions.forEach((item, index) => {
          that.competitionMap.set(item.id, item)
        })
      })
    },
    queryUserSignCompetitions() {
      let that = this
      let userId = that.userId
      return that.fetch("/api/competition/all/signIn/" + userId).then(result => {

        if (result.length != 2) {
          return
        }

        let data = result[1].data
        if (Array.isArray(data)) {
          data.forEach((item, index) => {
            that.userSignCompetitions.set(item.id, item)
          })
        } else {
          console.log("目前还没有人报名")
        }
      })
    },
    signIn(competitionId) {
      console.log("比赛id " + competitionId)
      let userCompetitionSign = this.userSignCompetitions.get(competitionId)
      if (userCompetitionSign.status == 0) {
        this.signInStatus = "取消签到"
        this.signInValue = 1
      } else {
        this.signInStatus = "签到"
        this.signInValue = 0
      }
      this.$refs.alertDialog.open()
    },
    dialogConfirm() {
      let that = this
      let userId = that.userId
      uni.request({
        url: this.getBaseUrl() + "/api/competition/signIn",
        method: 'POST',
        data: {
          id: 1,
          userId: "xxx",
          action: that.signInValue
        },
        header: this.jsonHeader,
        success: (res) => {
          let signInStatus = res.data
          that.preLoadData()
        },
        fail: (err) => {
        }

      })
    }
  }
};
</script>

<style lang="scss">
.container {
  /* text-align: center; */
  /* height: 400upx; */
  /* margin-top: 200upx; */
  background-color: #fff;
  padding: 10px;

}

.uni-row {
  flex-direction: row;
}

.uni-column {
  flex-direction: column;

}

.chat-custom-container {
  flex: 1;
  /* #ifndef APP-NVUE */
  display: flex;
  /* #endif */
  flex-direction: row;
  justify-content: space-between;
  align-items: flex-end;
}

.chat-custom-right {
  flex: 1;
  /* #ifndef APP-NVUE */
  display: flex;
  /* #endif */
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-end;
}

.chat-custom-right.first {
  margin-right: 10px;
}

.chat-custom-text {
  font-size: 12px;
  color: #999;
}

.chat-custom-text.count {
  color: #ff5a5f;
}


@mixin flex {
  /* #ifndef APP-NVUE */
  display: flex;
  /* #endif */
  flex-direction: row;
}
.box {
  @include flex;
}
</style>