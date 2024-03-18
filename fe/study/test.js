// async function fetchData() {
//     console.log("准备开始拉取数据")
//     await sleep(3000)
//     console.log("拉取数据完毕")
// }
//
// function sleep(ms) {
//     return new Promise(resolve => setTimeout(resolve, ms))
// }
//
// console.log("开始发起网络请求")
// fetchData().then(() => console.log("结束网络请求"))

export const myName1 = () => {
    console.log(`arrow function name myName1}`)
}

export const myName2 = () => {
    console.log(`arrow function name myName2`)
}

export class MyClass {
    constructor(name) {
        this.name = name
        this._myProperty = "hello"
    }

    set myProperty(newValue) {
        this._myProperty = newValue
    }

    get myProperty() {
        return this._myProperty
    }
}

