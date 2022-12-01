// 회원 전용 라우터
import { useContext } from 'react';
import LoginPage from '../page/LoginPage';
import ContextStore from './../../utilities/ContextStore';
// - ContextStore를 조사하여 로그인 여부를 판정
// - 로그인이 되어 있으면 통과, 아니면 로그인 페이지로 이동
const MemberRoute = props => {
    const {login} = useContext(ContextStore);

    if(login) { // 로그인 상태인 경우
        // 통과
        return <>{props.children}</>
    }
    else { // 로그인 상태가 아닌 경우
        // 차단
        return <LoginPage/>
    }
}

export default MemberRoute;