import './App.css';
import MainPage from './components/page/MainPage';
import MainFooter from './components/template/MainFooter';
import MainHeader from './components/template/MainHeader';
import MainMenu from './components/template/MainMenu';
import LoginPage from './components/page/LoginPage';
import BoardListPage from './components/page/BoardListPage';
import NotFound from './components/error/NotFound';

import {Routes, Route} from 'react-router';
import MyPage from './components/page/MyPage';
import { useEffect } from 'react';
import axios from './utilities/AxiosManager';
import PublicRoute from './components/route/PublicRoute';
import MemberRoute from './components/route/MemberRoute';

const App = () => {

  // 최초 1회 토큰 검사 후 로그인 갱신 처리
  useEffect(() => {
    //console.log(window.sessionStroage)
    const token = window.sessionStorage.getItem("token");
    //console.log(token);

    if(token) {
      axios({
        url : "http://localhost:8888/member/refresh/"+token,
      }).then(respObject => {}).catch(e => {}).finally(() => {});
    }
  }, {});

  return (
    <>
      {/* 헤더, 메뉴, 본문, 푸터 등으로 컴포넌트를 분할해야 함 */}
      <MainHeader/>
      <MainMenu/>
      
      {/* 상황에 맞게 주소에 따른 화면을 보여주도록 라우팅 처리 */}
      <Routes>
        <Route path='/' element={
          <PublicRoute>
            <MainPage/>
          </PublicRoute>}>
        </Route>

        <Route path='/login' element={
          <PublicRoute>
            <LoginPage/>
          </PublicRoute>}>
        </Route>

        <Route path='/board/list' element={
          <PublicRoute>
            <BoardListPage/>
          </PublicRoute>}>
        </Route>

        <Route path='/member/mypage' element={
          <MemberRoute>
            <MyPage/>
          </MemberRoute>}>
        </Route>

        <Route path='*' element={
          <MemberRoute>
            <NotFound/>
          </MemberRoute>}>
        </Route>
      </Routes>

      <MainFooter/>
    </>
  );
}

export default App;
