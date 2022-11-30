import './App.css';
import MainHeader from './components/template/MainHeader';
import MainMenu from './components/template/MainMenu';
import MainFooter from './components/template/MainFooter';
import MainPage from './components/page/MainPage';

import {Routes, Route} from 'react-router';
import LoginPage from './components/page/LoginPage';
import BoardListPage from './components/page/BoardListPage';
import NotFound from './components/error/NotFound';

const App = () => {
  return (
    <>
      {/* 헤더, 메뉴, 본문, 푸터 등으로 컴포넌트를 분할해야 함 */}
      <MainHeader/>
      <MainMenu/>
      
      {/* 상황에 맞게 주소에 따른 화면을 보여주도록 라우팅 처리 */}
      <Routes>
        <Route path = '/' element = {<MainPage/>}></Route>
        <Route path = '/login' element = {<LoginPage/>}></Route>
        <Route path = '/board/list' element = {<BoardListPage/>}></Route>
        <Route path = '*' element = {<NotFound/>}></Route>
      </Routes>

      <MainFooter/>
    </>
  );
}

export default App;
