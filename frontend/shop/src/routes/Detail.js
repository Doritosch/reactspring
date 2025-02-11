import { useEffect, useState } from "react";
import { useParams, useResolvedPath } from "react-router-dom";
import styled from 'styled-components'

let YellowButten = styled.button`
  background : ${ props => props.bg};
  color : black;
  padding : 10px;
`
let greyBack = styled.div`
  background : grey;
  padding : 20px;
`

function Detail(props) {
  
    let {id} = useParams();
    let findItem = props.shoes.find(function(x) {
      return x.id == id
    });
    let [alert, setAlert] = useState(true);

    useEffect(()=> {
      setTimeout(()=>{
        setAlert(false)}, 2000)
    }, [])

    return (
        <div className="container">
          {
            (alert==true)?
            <div className="alert alert-warning">2초이내 구매시 할인 </div>: null
          }
          <YellowButten bg="green"></YellowButten>
        <div className="row">
          <div className="col-md-6">
            <img src="https://codingapple1.github.io/shop/shoes1.jpg" width="100%" />
          </div>
          <div className="col-md-6">
            <h4 className="pt-5">{findItem.title}</h4>
            <p>{findItem.content}</p>
            <p>{findItem.price} 원</p>
            <button className="btn btn-danger">주문하기</button> 
          </div>
        </div>
      </div> 
    )
  }

export default Detail;