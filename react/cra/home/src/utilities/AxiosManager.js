// axios를 프로젝트 내에서 유일하게 사용할 수 있도록 처리하는 파일

import axios from 'axios';

// axios에 대한 설정 추가(필요하다면)
// - cookie를 같이 보냄
axios.defaults.withCredentials = true;

export default axios;