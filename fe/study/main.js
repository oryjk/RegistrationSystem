import {MyClass, myName2} from "./test.js";

myName2()

let myClass = new MyClass("wangrui");
console.log(myClass.myProperty)
myClass.myProperty = "wangrui"
console.log(myClass.myProperty)
setTimeout((name, age) => {
    console.log(`hello ${name}, ${age}`)
}, 1000, "zhoupengxiao",19)