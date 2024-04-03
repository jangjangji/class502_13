import { Component } from 'react';
import PropTypes from 'prop-types';

class MyComponent extends Component {
  static defaultProps = {
    name: '기본 이름',
  };
  render() {
    const { name, num, children } = this.props;

    return (
      <>
        <div>안녕하세요!, 제 이름은 {name}입니다.</div>
        <div>좋아하는 숫자는 {num}입니다.</div>
        {children}
      </>
    );
  }
}

MyComponent.defaultProps = {
  name: '기본이름',
};
MyComponent.propTypes ={
    name: PropTypes.string,
    num: PropTypes.number.isRequired,

}

export default MyComponent;


/* 컴포넌트 재 렌더링 기준 - 함수형 컴포넌트 다시 호출, 클래스형 컴포넌트 -render 함수 다시 호출

1) props값이 변경
2) state 값이 변경
3) 부모컴포넌트가 렌더링 되면 -> 자식 컴포넌트도 함께 렌더링
4) 클래스형 컴포넌트 this.forceUpdate(): 강제 렌더링

state - 컴포넌트 내부에서 바뀔 수 있는 값을 의미
함수형 컴포넌트에서 useState() -> 배열 값 -> 0번째는 상태값, 1 상태값 변경    함수-> 후 다시 렌더링
*/