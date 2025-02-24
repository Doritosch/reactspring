import logo from './logo.svg';
import './App.css';
import {Button, Nav, Navbar, Container, Col, Row} from 'react-bootstrap';
import { useState } from 'react';
import data from './data.js'
import {Routes, Route, Link, useNavigate, Outlet} from 'react-router-dom'
import Detail from './routes/Detail.js';
import axios from 'axios';

function App() {

  let [shoes, setShoes] = useState(data);
  let navigate = useNavigate();

  return (
    <div className="App">
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="#home">Shop</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link onClick={()=>{navigate('/')}}>Home</Nav.Link>
            <Nav.Link onClick={()=>{navigate('/detail')}}>Detail</Nav.Link>
            <Nav.Link href="#pricing">MyPage</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      
      <Link to="/">홈</Link>
      <Link to="/detail">상세 페이지</Link>
      <Routes>
        <Route path="/" element={
          <>
            <div className="main-bg"></div>  
            <div className='Container'>
            <Row>
              {
                shoes.map(function(a, i) {
                  return (
                    <Modal id={i} shoes={shoes[i]}></Modal>
                  )
                })
              }
            </Row>
            </div>
            <button onClick={()=> {
              axios.get('https://codingapple1.github.io/shop/data2.json')
              .then((result)=>{
                let copy = [...shoes, ...result.data];
                setShoes(copy);
              })
              .catch(()=>{
                console.log("fail")
              })
            }}>load</button>
          </>
        }></Route>
        <Route path="/detail/:id" element={<Detail shoes={shoes}/>}/>
        <Route path="/about" element={<About></About>}>
          <Route path="member" element={<div>회사원</div>}/> 
        </Route>
        <Route path="*" element={<div>없는 페이지</div>}/>
        <Route/>
      </Routes>    
    </div>
  );
}

function About(){
  return (
    <div>
      <h4>회사정보</h4>
      <Outlet></Outlet>
    </div>
  )
}
function Modal(props) {
  return (
      <Col>
        <img src={props.shoes.image} width="80%"></img>
        <p>{props.shoes.title}</p>
        <p>{props.shoes.content}</p>
        <p>{props.shoes.price}원</p>
      </Col>
  )
}

export default App;
