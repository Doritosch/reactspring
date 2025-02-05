import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

  let [글제목, title] = useState(['남자 코트 추천', '규동 맛집 추천', '중화 요리 추천']); // state: 변수 변경시 자동으로 재랜더링 되게 함
  let [좋아요, like] = useState([0,0,0]);
  let [modal, setModal] = useState(false);
  let [titleIdx, changeIdx] = useState(0);

  return (
    <div className="App">
      <div className='black-nav'>
        <h4>ReactBlog</h4>
      </div>
      <button onClick={()=> {
        let copy = [...글제목];
        copy[0] = '여자 코트 추천';
        title(copy);
      }}>남-여</button>
      <button onClick={()=>{
        let copy = [...글제목];
        copy.sort();
        title(copy);
      }}>가나다순정렬</button>
      {/* <div className="list">
        <h4>{글제목[0]} <span onClick={()=>{like(좋아요+1)}}>👍</span>{좋아요}</h4>
        <p>2월4일 <span onClick={()=>{title(글제목[0] = '여자코트 추천')}}>👍</span></p>
      </div>
      <div className="list">
        <h4>{글제목[1]}</h4>
        <p>2월4일</p>
      </div>
      <div className="list">
        <h4 onClick={()=>{
          if(modal==true) {
            setModal(false);
          } else {
            setModal(true);
          }
        }}>{글제목[2]}</h4>
        <p>2월4일</p>
      </div> */}
      {
        글제목.map(function(a, i){
          return (
            <div className="list" key={i}>
              <h4 onClick={(e)=> {setModal(true); changeIdx(i)}}>{글제목[i]} <span onClick={()=>{
                let copy = [...좋아요];
                copy[i] = copy[i]+1;
                like(copy)
              }}>👍</span>{좋아요[i]}</h4>
              <p>2월4일</p>
            </div>
          )
        })
      }
      {
        modal==true?<Modal titleIdx={titleIdx} title={title} 글제목={글제목}/>: null
      }
    </div>
  );
}

function Modal(props) {
  return (
    <div className='modal'>
      <h4>{props.글제목[props.titleIdx]}</h4>
      <p>날짜</p>
      <p>상세내용</p>
      <button onClick={()=>{
        let copy = [...props.글제목];
        copy[0] = "여자 코트 추천";
        props.title(copy);
      }}>글수정</button>
    </div>
  )
}
export default App;
