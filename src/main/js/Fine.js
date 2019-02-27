import React from 'react';
import ReactDOM from 'react-dom';
import FineByBorrower from './FineByBorrower'
// import './App.css';
// const React = require('react');
// const ReactDOM = require('react-dom');

class Fine extends React.Component {

  constructor(props) {
      super(props);
      this.state = {
          searchString : "",
          fineByBorrower: {
            "borrower":{
              "borrowerId": "",
              "firstName": "",
              "lastName": "",
            },
            "fines":[],
            "totalFine":{
              "payableFine":0
            }
          }
      };
      this.handleChange = this.handleChange.bind(this);
      this.refreshFines = this.refreshFines.bind(this);
  }

  refreshFines(event){
    event.preventDefault();
        fetch(`http://localhost:8080/fine/refresh`)
        .then((response) => {
                if(!response.ok){
                    throw new Error(response.status);
                } 
                else {
                  console.log("Refresh Fines successfull");
                }
        })
  }

  handleChange(event) {
      event.preventDefault();
      var newSearchString = document.getElementById("search").value;
      console.log(newSearchString)
      if(newSearchString.trim() === ""){
          this.setState({
              searchString : "",
              fineByBorrower: {
                "borrower":{
                  "borrowerId": "",
                  "firstName": "",
                  "lastName": "",
                },
                "fines":[],
                "totalFine":{
                  "payableFine":0
                }
              }
            });
      }else{
          fetch(`http://localhost:8080/fine/borrower/`+newSearchString)
              .then(res => res.json())
              .then(data => {
                  console.log({ data });
                  this.setState({
                      searchString: newSearchString,
                      fineByBorrower : data
                  });
              })
              .catch(err => {
                console.log(err)
                this.setState({
                  searchString : "",
                  fineByBorrower: {
                    "borrower":{
                      "borrowerId": "",
                      "firstName": "",
                      "lastName": "",
                    },
                    "fines":[],
                    "totalFine":{
                      "payableFine":0
                    }
                  }
                });
              });
          
      }

  }

  componentDidMount() {
    this.setState({
      searchString : "",
      fineByBorrower : {
        "borrower":{
          "borrowerId": "",
          "firstName": "",
          "lastName": "",
        },
        "fines":[],
        "totalFine":{
          "payableFine":0
        }
      }
    });  
  }

  render() {
      return (
          <div>
              <h1>Library Management System</h1>
              <h2>Fine Portal</h2>
              <button onClick={this.refreshFines}>Refresh Fines</button>
              <h3>Search Borrower Fines</h3>
              <div>
                <form>
                  <input id="search" type="text" placeholder="type borrower id" />
                  <button onClick={this.handleChange}>Search</button>
                  <hr />
                </form>
                
              </div>
              <FineByBorrower fineByBorrower={this.state.fineByBorrower}/>
          </div>
  )
  }
}

export default Fine;