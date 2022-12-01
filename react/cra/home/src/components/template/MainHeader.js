//헤더 컴포넌트
import { useContext } from 'react';
import ContextStore from './../../utilities/ContextStore';
// - ContextStore에 있는 login 값을 읽어 상황에 맞는 메뉴를 반환
const MainHeader = props=>{

    //const store = useContext(ContextStore); // 전체
    const {login} = useContext(ContextStore); // login만

    return (
        <>
            <div>
                <h1>Header!</h1>
            </div>
        </>
    );
};

export default MainHeader;