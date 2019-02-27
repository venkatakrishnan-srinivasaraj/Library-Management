import React from 'react';
import ReactDOM from 'react-dom';


class SearchResult extends React.Component {

    render() {
        return (
            <tr>
                <td>{this.props.searchResult.bookAuthorMap.book.isbn13}</td>
                <td>{this.props.searchResult.bookAuthorMap.book.title}</td>
                <td>{this.props.searchResult.bookAuthorMap.author.name}</td>
                <td>{this.props.searchResult.bookAuthorMap.book.publisher}</td>
                <td><button disabled={!this.props.searchResult.bookAvailableForBorrowing}>Available</button></td>
            </tr>
        )
    }
  }

  export default SearchResult;