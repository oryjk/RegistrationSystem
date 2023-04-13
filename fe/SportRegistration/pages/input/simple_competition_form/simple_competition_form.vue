<template>
  <view class="content">
    <uni-forms ref="form" label-position="left" label-width="80px">
      <uni-section title="必填项" type="line">
        <uni-forms-item label="活动名称" required>
          <uni-easyinput type="text" v-model="formData.name" placeholder="请输入活动名称"/>
        </uni-forms-item>
        <uni-forms-item label="活动介绍" required>
          <uni-easyinput type="textarea" v-model="formData.competitionStatement"
                         placeholder="稍微介绍一下你的活动内容"/>
        </uni-forms-item>
        <uni-forms-item label="比赛形式" required>
          <uni-data-select v-model="formData.gameType" :localdata="gameType" :clear="false"></uni-data-select>
        </uni-forms-item>
      </uni-section>
      <uni-section title="选填项" type="line">
        <uni-forms-item label="活动时间">
          <uni-datetime-picker type="datetime" :clear-icon="true" v-model="formData.gameDate"/>
        </uni-forms-item>
        <uni-forms-item label="截止时间">
          <uni-datetime-picker type="datetime" :clear-icon="true" v-model="formData.deadline"/>
        </uni-forms-item>
        <uni-forms-item label="活动地点">
          <map id="map" class="map" :show-location="true" :latitude="formData.latitude"
               :longitude="formData.longitude"></map>
          <button type="primary" size="mini" @click="onVenue">新增域名</button>
        </uni-forms-item>
        <uni-forms-item label="费用方式">
          <uni-data-select v-model="formData.feeType" :localdata="formData.feeTypeRange" :clear="false">
          </uni-data-select>
        </uni-forms-item>
        <uni-forms-item label="比赛方式">
          <uni-data-select v-model="formData.competitionType" :localdata="formData.competitionTypeRange"
                           :clear="false"></uni-data-select>
        </uni-forms-item>
      </uni-section>

      <view class="segmented-control">
        <uni-segmented-control :current="formData.current" :values="formData.items" @clickItem="onClickItem"
                               styleType="button">
        </uni-segmented-control>
      </view>
    </uni-forms>

  </view>
</template>

<script>
export default {
  data() {
    return {
      serverUrl: "localhost",
      port: "5678",

      gameType: [{
        value: "Internal",
        text: "队内比赛"
      },
        {
          value: "External",
          text: "队外比赛"
        }
      ],

      formData: {
        name: '',
        competitionStatement: '',
        venue: '',
        gameDate: '',
        gameType: 'Internal',
        feeType: 0,
        feeTypeRange: [{
          value: 0,
          text: "AA"
        },
          {
            value: 1,
            text: "免费"
          }
        ],
        competitionType: 0,
        competitionTypeRange: [{
          value: 0,
          text: "5V5"
        },
          {
            value: 1,
            text: "7V7"
          }
        ],
        // 分段器数据
        current: 0,
        items: ['保存为草稿', '保存并发布'],
        latitude: 104.04311,
        longitude: 30.64242

      }

    };
  },
  onLoad() {
  },
  methods: {
    onVenue(e) {
      // uni.chooseLocation({
      // 	success: function(res) {
      // 		console.log('位置名称：' + res.name);
      // 		console.log('详细地址：' + res.address);
      // 		console.log('纬度：' + res.latitude);
      // 		console.log('经度：' + res.longitude);
      // 		formData.latitude = res.latitude;
      // 		this.formData.longitude = res.longitude;
      // 	}
      // });

      let that = this
      uni.getLocation({
        type: 'wgs84',
        success: (res) => {
          console.log('当前位置的经度：' + res.province);
          console.log('当前位置的纬度：' + res.city);
          console.log('当前位置的纬度：' + res.district);
          console.log('当前位置的纬度：' + res.street);

          that.formData.longitude = res.longitude
          that.formData.latitude = res.latitude
        }
      });
    },

    onClickItem(e) {
      let currentIndex = e.currentIndex
      let that = this
      if (currentIndex === 1) {
        console.log('点击了保存与发布按钮')
        uni.request({
          url: "http://" + that.serverUrl + ":" + that.port + "/api/competition/create",
          method: 'POST',
          data: {
            name: this.formData.name,
            gameDate: this.formData.gameDate,
            gameType: this.formData.gameType,
            venue: this.formData.venue,
            contacts: '',
            competitionStatement: this.formData.competitionStatement,
            applicantsLimit: 12

          },


          success: (res) => {
            console.log(res)
            this.formData.address = ""
          }

        })

      }
      if (currentIndex === 0) {
        console.log('点击了保存为草稿按钮')
      }

      console.log(e)
    }
  }
};
</script>

<style lang="scss">
.xxxxx {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;

  .left-btn {
    background-color: #f8f8f8;
    color: #898989;

  }

  .right-btn {
    background-color: #51aa37;
    color: #bde7b0;

  }
}


.text {
  font-size: 12px;
  color: #666;
  margin-top: 5px;
}

.uni-px-5 {
  padding-left: 10px;
  padding-right: 10px;
}

.uni-pb-5 {
  padding-bottom: 10px;
}

.segmented-control {
  margin-bottom: 15px;
}
</style>