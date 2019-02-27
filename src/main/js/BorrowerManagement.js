import React from 'react';
import ReactDOM from 'react-dom';

class BorrowerManagement extends React.Component {

  constructor(props) {
      super(props);
      this.state = {
        borrower:{
            "firstName":"",
            "lastName":"",
            "ssn" : "",
            "email":"",
            "phoneNumber":""
        }
    };  
      this.handleSubmit = this.handleSubmit.bind(this);
      this.handleInput = this.handleInput.bind(this);
  }

  handleInput(event) {
    let name = event.target.name;
    let value = event.target.value;
    this.setState(
      prevState => ({
        borrower: {
          ...prevState.borrower,
          [name]: value
        }
      }));
  }

  handleSubmit(event) {
    event.preventDefault();
    let borrower = this.state.borrower;

    fetch("http://localhost:8080/borrower", {
      method: "POST",
      body: JSON.stringify(borrower),
      headers: {
        "Content-Type": "application/json"
      }
    }).then(response => {
       console.log(response.text())
    })
  }

  componentDidMount() {
    this.setState({
        borrower:{
            "firstName":"",
            "lastName":"",
            "ssn" : "",
            "email":"",
            "phoneNumber":""
        }
    });  
  }

  render() {
      return (
          <div>
              <h1>Library Management</h1>
              <h2>Borrower Management</h2>
              <div>
                <form onSubmit={this.handleSubmit}>
                  <label htmlFor="firstName">Enter FirstName</label>
                  <br/>
                  <input name="firstName" value={this.state.borrower.firstName} type="text" onChange={this.handleInput} required/>
                  <br/>
                  <label htmlFor="lastName" >Enter LastName</label>
                  <br/>
                  <input name="lastName" value={this.state.borrower.lastName} type="text" onChange={this.handleInput} required/>
                  <br/>
                  <label htmlFor="ssn">Enter SSN</label>
                  <br/>
                  <input name="ssn" type="text" value={this.state.borrower.ssn} onChange={this.handleInput} required/>
                  <br/>
                  <label htmlFor="email">Enter E-mail</label>
                  <br/>
                  <input name="email" type="text" value={this.state.borrower.email} onChange={this.handleInput}/>
                  <br/>
                  <label htmlFor="phoneNumber">Enter PhoneNumber</label>
                  <br/>
                  <input name="phoneNumber" type="text" value={this.state.borrower.phoneNumber} onChange={this.handleInput}/>
                  <br/>
                  <br/>
                  <br/>
                  <button onClick={this.handleChange}>Create Borrower</button>
                  
                </form>
              </div>
          </div>
  )
  }
}


export default BorrowerManagement;