<template>
	<view class="content">
		<uni-forms ref="form" label-position="left" label-width="80px">
			<uni-section title="必填项" type="line">
				<uni-forms-item label="活动名称" required>
					<uni-easyinput type="text" v-model="formData.name" placeholder="请输入活动名称" />
				</uni-forms-item>
				<uni-forms-item label="活动介绍" required>
					<uni-easyinput type="textarea" v-model="formData.description" placeholder="稍微介绍一下你的活动内容" />
				</uni-forms-item>
			</uni-section>
			<uni-section title="选填项" type="line">
				<uni-forms-item label="活动时间">
					<uni-datetime-picker type="datetime" :clear-icon="true" v-model="formData.single" />
				</uni-forms-item>
				<uni-forms-item label="活动地点">
					<uni-easyinput type="text" v-model="formData.address" placeholder="请输入活动名称" />
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
			<view class="xxxxx">
				<button type="default" class="left-btn">保存为草稿</button><button type="default" class="right-btn">保存并发布</button>
			</view>
		</uni-forms>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				formData: {
					name: '',
					email: 'dcloud@email.com',
					description: '',
					address: '',
					single: '',
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

				}

			};
		},
		onLoad() {},
		methods: {}
	};
</script>

<style lang="scss">
	@import '@/uni_modules/uni-scss/styles/setting/_styles.scss';

	.xxxxx {
		display: flex;
		flex-direction: row;
		justify-content: flex-start;

		.left-btn {
			background-color: #f8f8f8;
			color: #898989;
			
		}
		.right-btn{
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
</style>
