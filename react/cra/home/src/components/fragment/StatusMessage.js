// 상태 메시지 도구
// - props에 status라는 이름으로 상태 코드가 들어온다
// - 200(성공), 400(파라미터 불일치), 401(권한 없음), 403(권한 부족), 404(못찾음), 500(서버 에러)

const StatusMessage = props=>{
    switch(props.status) {
        case 200: return <h2>정상적으로 완료되었습니다</h2>
        case 400: return <h2>파라미터가 일치하지 않습니다</h2>
        case 401: return <h2>로그인이 필요합니다</h2>
        case 403: return <h2>이용할 권한이 부족합니다</h2>
        case 404: return <h2>일치하는 정보가 없습니다</h2>
        case 500: return <h2>서버에서 처리 오류가 발생했습니다</h2>
        default : return <></>
    }
};

export default StatusMessage