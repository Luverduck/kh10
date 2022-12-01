//메인 메뉴
//- ContextStore에 있는 login 값을 읽어 상황에 맞는 메뉴를 반환

import {Link} from 'react-router-dom';
import { useContext } from 'react';
import ContextStore from './../../utilities/ContextStore';
import { useNavigate } from 'react-router';

const MainMenu = props=>{
    const navigate = useNavigate();

    //const store = useContext(ContextStore);//전체
    const {login, setMember, setToken} = useContext(ContextStore);//login만

    //로그아웃 처리 핸들러
    const logoutProcess = e=>{
        e.preventDefault();

        //ContextStore의 데이터 삭제
        setMember(null);
        setToken(null);

        //sessionStorage에 토큰을 삭제
        window.sessionStorage.removeItem("token");

        navigate("/");
    };

    if(login){//로그인 상태일 때의 메뉴
        return (<>
            <div>
                <h1>
                    {/* router에 대한 이동 링크는 Link 태그로 작성한다 */}
                    <Link to='/'>Home</Link>
                    &nbsp;&nbsp;
                    <Link onClick={logoutProcess}>Logout</Link>
                    &nbsp;&nbsp;
                    <Link to='/member/mypage'>MyPage</Link>
                    &nbsp;&nbsp;
                    <Link to='/board/list'>Board</Link>
                </h1>
            </div>
        </>);
    }
    else {//로그아웃 상태일 때의 메뉴
        return (<>
            <div>
                <h1>
                    {/* router에 대한 이동 링크는 Link 태그로 작성한다 */}
                    <Link to='/'>Home</Link>
                    &nbsp;&nbsp;
                    <Link to='/login'>Login</Link>
                    &nbsp;&nbsp;
                    <Link to='/board/list'>Board</Link>
                </h1>
            </div>
        </>);
    }

};

export default MainMenu;