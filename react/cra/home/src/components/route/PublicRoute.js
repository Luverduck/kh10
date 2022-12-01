// public route component
// - 모든 사용자가 접근 가능한 컴포넌트
// - Route와 동일하지만 이름을 다르게 하기 위해서 개조 처리

const PublicRoute = props => {
    return <>{props.children}</>
};

export default PublicRoute;