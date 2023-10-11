export default defineAppConfig({
    pages: [
        'pages/index/index'
    ],
    window: {
        backgroundTextStyle: 'light',
        navigationBarBackgroundColor: '#fff',
        navigationBarTitleText: 'WeChat',
        navigationBarTextStyle: 'black'
    },
    tabBar: {
        custom: true,
        color: '#000000',
        selectedColor: '#000000',
        backgroundColor: '#000000',
        list: [
            {
                pagePath: 'pages/component/index',
                text: '组件',
            },
            {
                pagePath: 'pages/API/index',
                text: '接口',
            },
        ],
    },
})
