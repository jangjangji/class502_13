const MyComponent = ({name, num,children}) => {//더 짧게 매개변수로 분해해서 쓰자
    return( 
    <>
        <div>안녕하세요!, 제 이름은 {name}입니다.</div>
        <div>제가 좋아하는 숫자는 {num}입니다. </div>
        {children}
    </>
    );
};

export default MyComponent;








/* children - 컴포넌트 태그 안에 정의된 내용 컴포넌트 안내용은 children으로 사용가능

*/