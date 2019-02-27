import React from 'react';
import ReactDOM from 'react-dom';


class FineResult extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.fineResult.fineId}</td>
                <td>{this.props.fineResult.bookLoan.book.title}</td>
                <td>{this.props.fineResult.fineAmount}</td>
            </tr>
        )
    }
  }

  export default FineResult;