// Context API를 사용하여 컴포넌트에서 모두 접근 및 변경이 가능한 저장소를 구현

import { createContext, useEffect } from "react";
import { useState } from 'react';

// - react에 내장된 createContext라는 함수를 저장소로 생성
const ContextStore = createContext(null);

export default ContextStore;

// - 기본 제공되는 ContextStore의 Provider로는 읽기만 가능
// - 개조해서 Custom Provider를 만든 다음 state를 추가하여 데이터 변화를 관리
const ContextCustomProvider = props => {

    // - 전체 어플리케이션에서 사용하고자 하는 값을 state로 선언
    const [member, setMember] = useState(null);
    const [token, setToken] = useState(null);
    const [login, setLogin] = useState(false);

    useEffect(() => {
        setLogin(token != null);
    }, [token]);

    // - 함수형 컴포넌트는 무조건 JSX를 반환해야 한다
    // - 원래 작성된 ContextStore.Provider와 내부 정보를 JSX로 반환하도록 설정
    // - state를 추가하고 value로 내보내서 전체에서 사용 가능하도록 구현
    const valueObject = {
        member : member, // member 읽기 허용
        setMember, // setMember 접근 허용
        token : token, // token 읽기 허용
        setToken,
        login : login // login 읽기 허용
    }
    return (
        <ContextStore.Provider value = {valueObject}>
            {/* Provider 사이의 <App/>을 읽어오도록 한다 
                - 원래 Provider의 내부 태그 정보
            */}
            {props.children}
        </ContextStore.Provider>
    );
};

export {ContextCustomProvider};