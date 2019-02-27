import React from 'react';
import ReactDOM from 'react-dom';
import FineResult from './FineResult'

class FineByBorrower extends React.Component {
    constructor(props){
        super(props)
        this.state={
            alreadyPaid:false
        }
        this.performPayment = this.performPayment.bind(this);
    }

    componentDidMount(){
        this.setState({
            alreadyPaid:false
        })
    }

    performPayment(event){
        event.preventDefault();
        const borrowerId = this.props.fineByBorrower.borrower.borrowerId
        fetch(`http://localhost:8080/fine/payment/borrower/`+borrowerId)
        .then((response) => {
                if(!response.ok){
                    throw new Error(response.status);
                } 
                else {
                    this.setState({ 
                        alreadyPaid: true
                    });
                    console.log("Payment Success");
                }
        })
    }



    render() {

        const fineByBorrower = this.props.fineByBorrower
        const totalFine = fineByBorrower.totalFine.payableFine
        const borrowerId = fineByBorrower.borrower.borrowerId
        const firstName = fineByBorrower.borrower.firstName
        const lastName = fineByBorrower.borrower.lastName
        
        const fineResults = fineByBorrower.fines.map(fineResult =>
            <FineResult key={fineResult.fineId} fineResult={fineResult}/>
        );

        return (
            <div>
            <h4>Borrower ID : {borrowerId}</h4>
            <h4>FirstName : {firstName}</h4>
            <h4>LastName : {lastName}</h4>
            <table>
                <tbody>
                <tr>
                    <th>Fine Id</th>
                    <th>Book Title</th>
                    <th>Fine Amount</th>
                </tr>
                {fineResults}
                <tr>
                    <td>Total</td>
                    <td/>
                    <td>{totalFine}</td>
                </tr>
                </tbody>
            </table>
            <button disabled={this.state.alreadyPaid} onClick={this.performPayment}>Pay Fine</button>
            </div>
        )
    }
  }

  export default FineByBorrower;