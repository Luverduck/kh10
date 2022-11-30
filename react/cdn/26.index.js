// import {a} from "./26.module.js";
// import {b} from "./26.module.js";
// import {name} from "./26.module.js";
// import {hello} from "./26.module.js";

// 무조건 함수 먼저
import hello, {a, b, name} from "./26.module.js";

console.log(a, b, name);
hello();