const App = () => {
  const name = 'React';

  const style = {
    backgroundColor: 'orange',
    color: 'white',
    height: '100px',
  };

  return (
    <>
      <div className="subject" style={style}>
        첫번쨰 컴포넌트!
      </div>
      <div style={{ color: 'blue' }}>신나는, {name && name} 공부</div>
      {name === 'React' && <h1>아! 재미있다</h1>}
      <input type="text" />
    </>
  );
};

export default App;
