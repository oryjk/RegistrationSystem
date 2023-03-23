<script>
export default {
	onLaunch: function() {
		console.log('App Launch');

		setTimeout(() => {
			uni.setTabBarBadge({
				index: 2,
				text: '31'
			});
			uni.showTabBarRedDot({
				index: 1
			});
		}, 1000);
	},
	onShow: function() {
		console.log('App Show');
	},
	onHide: function() {
		console.log('App Hide');
	}
};
</script>

<style lang='scss'>

</style>
