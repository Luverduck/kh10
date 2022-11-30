// 메인 메뉴
import {Link} from 'react-router-dom';

const MainMenu = props => {
    return (<>
        <div>
            <h1>
                {/* router에 대한 이동 링크는 Link 태그로 작성한다 */}
                <Link to = '/'>Home</Link>
                &nbsp;&nbsp;
                <Link to = '/login'>Login</Link>
                &nbsp;&nbsp;
                <Link to = '/board/list'>Board</Link>
                &nbsp;&nbsp;
            </h1>
        </div>
    </>);
};

export default MainMenu;