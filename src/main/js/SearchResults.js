import React from 'react';
import ReactDOM from 'react-dom';
import SearchResult from './SearchResult'

class SearchResults extends React.Component {
    render() {
        const searchResults = this.props.searchResults.map(searchResult =>
            <SearchResult key={searchResult.bookAuthorMap.book.isbn13} searchResult={searchResult}/>
        );
  
        return (
            <table>
                <tbody>
                <tr>
                    <th>Isbn 13</th>
                    <th>Book Title</th>
                    <th>Author</th>
                    <th>Publisher</th>
                    <th>Availability</th>
                </tr>
                {searchResults}
                </tbody>
            </table>
        )
    }
  }

  export default SearchResults;