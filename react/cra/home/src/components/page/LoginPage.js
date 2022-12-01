//로그인 페이지
import { useState } from 'react';
//- 아이디와 비밀번호 입력창, 로그인 버튼이 있어야 함
//- 로그인 버튼을 누르면 비동기 통신으로 서버에 아이디와 비밀번호를 전송해야 함

import axios from '../../utilities/AxiosManager';
import ContextStore from './../../utilities/ContextStore';
import { useContext } from 'react';

const LoginPage = props=>{
    //ContextStore 접근
    //const store = useContext(ContextStore);
    const {setMember, setToken} = useContext(ContextStore);

    //회원 정보
    const [inputMember, setInputMember] = useState({
        memberId:'',
        memberPw:''
    });

    //입력 내용 업데이트 함수
    const changeMemberInfo = e=>{
        const name = e.target.name;
        const value = e.target.value;

        setInputMember({
            ...inputMember,
            [name]:value
        });
    };

    //로그인 함수 - axios를 통해 서버의 로그인 컨트롤러에 member 정보를 전송
    const sendLoginInfo = e=>{
        //검사

        axios({
            url:"http://localhost:8888/member/login",
            method:"post",
            //responseType:"json"
            data:inputMember
        })
        .then(respObject=>{
            //console.log("성공", respObject.data);
            setMember(respObject.data.member);
            setToken(respObject.data.token);
        })
        .catch(e=>{
            console.log("실패", e);
        })
        .finally(()=>{});
    };

    return (<>
        <div>

            <h1>로그인</h1>
            
            <input type="text" name="memberId" placeholder="아이디" onChange={changeMemberInfo}></input>
            
            <br></br><br></br>

            <input type="password" name="memberPw" placeholder="비밀번호" onChange={changeMemberInfo}></input>

            <br></br><br></br>

            <button onClick={sendLoginInfo}>로그인</button>

        </div>
    </>);
};

export default LoginPage;