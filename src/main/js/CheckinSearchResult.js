import React from 'react';
import ReactDOM from 'react-dom';


class CheckinSearchResult extends React.Component {

    constructor(props){
        super(props)
        this.state={
            alreadyCheckedin:false
        }
        this.performCheckin = this.performCheckin.bind(this);
    }

    componentDidMount(){
        const returnDate = this.props.searchResult.returnDate;
        let alreadyCheckedinStatus = true;
        if(returnDate === null){
            alreadyCheckedinStatus = false;
        }
        this.setState({
            alreadyCheckedin:alreadyCheckedinStatus
        })
    }

    performCheckin(event){
        event.preventDefault();
        const bookLoanId = this.props.searchResult.bookLoanId
        fetch(`http://localhost:8080/book/checkin/perform/`+bookLoanId)
        .then((response) => {
                if(!response.ok){
                    throw new Error(response.status);
                } 
                else {
                    this.setState({ 
                        canCheckIn: true
                    });
                    console.log("Checkin Success");
                }
        })
    }

    render() {
        return (
            <tr>
                <td>{this.props.searchResult.bookLoanId}</td>
                <td>{this.props.searchResult.book.isbn13}</td>
                <td>{this.props.searchResult.book.isbn10}</td>
                <td>{this.props.searchResult.book.title}</td>
                <td>{this.props.searchResult.borrower.firstName}</td>
                <td>{this.props.searchResult.borrower.lastName}</td>
                <td><button disabled={this.state.alreadyCheckedin} onClick={this.performCheckin}>CheckIn</button></td>
            </tr>
        )
    }
  }

  export default CheckinSearchResult;