import { useContext } from 'react';
import ContextStore from './../../utilities/ContextStore';
import { Link } from 'react-router-dom';
const MyPage = props=>{
    const {member} = useContext(ContextStore);

    return(<>
        <h1>내 정보 보기</h1>
        <h2>아이디 : {member.memberId}</h2>
        <h2>닉네임 : {member.memberNick}</h2>
        <h2>포인트 : {member.memberPoint} point</h2>
        <h2>등급 : {member.memberGrade}</h2>

        <Link to="/">홈으로</Link>
    </>);
};

export default MyPage;