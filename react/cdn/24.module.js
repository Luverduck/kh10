// 모듈 방식에서는 내보낸 요소만 사용 가능
const a = 10;
const b = 20;
const c = a + b;

// 내보내는 방식은 2가지가 있다
// - 기본값으로 내보내는 방식 (export default)
//export {c}; // c를 외부에서 사용 가능하게 내보내라

// - 이름을 부여하여 내보내는 방식 (export)
//export const c = a + b;

function hello(){
    console.log("hello");
}
//export {hello};

// export function hello() {
//     console.log("hello");
// }

// 한번에 내보내기
export {c, hello};