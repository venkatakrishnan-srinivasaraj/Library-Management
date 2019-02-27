import React from 'react';
import ReactDOM from 'react-dom';
import CheckinSearchResult from './CheckinSearchResult'

class CheckinSearchResults extends React.Component {
    render() {
        const searchResults = this.props.searchResults.map(searchResult =>
            <CheckinSearchResult key={searchResult.bookLoanId} searchResult={searchResult}/>
        );
  
        return (
            <table>
                <tbody>
                <tr>
                    <th>Book LoanId</th>
                    <th>Isbn 13</th>
                    <th>Isbn 10</th>
                    <th>Title</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                </tr>
                {searchResults}
                </tbody>
            </table>
        )
    }
  }

  export default CheckinSearchResults;