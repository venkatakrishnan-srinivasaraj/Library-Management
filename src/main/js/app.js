const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            searchTerm : "",
            searchResults: []
        };
        this.handleChange = this.handleChange.bind(this);
        // this.refs.search.focus();
    }

    handleChange() {
        var newSearchString = this.refs.search.value
        if(newSearchString.trim() === ""){
            this.setState({
                searchString: "",
                searchResults : []
            });
        }else{
            fetch(`http://localhost:8080/search/`+newSearchString)
                .then(res => res.json())
                .then(data => {
                    console.log({ data });
                    this.setState({
                        searchString: newSearchString,
                        searchResults : data
                    });
                })
                .catch(err => console.log(err));
            this.setState({
                searchString: this.refs.search.value
            });
        }

    }

    componentDidMount() {
        fetch(`http://localhost:8080/search/mythology`)
            .then(res => res.json())
            .then(data => {
                console.log({ data });
                this.setState({
                    searchString : "",
                    searchResults : data
                });
            })
            .catch(err => console.log(err));
    }

    render() {
        return (
            <div>
                <h1>Library Management System</h1>
                <div>
                    <input
                        type="text"
                        value={this.state.searchString}
                        ref="search"
                        onChange={this.handleChange}
                        placeholder="type search string here"
                    />
                </div>
                <SearchResults searchResults={this.state.searchResults}/>
            </div>
    )
    }
}


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



class SearchResult extends React.Component {

    render() {
        return (
            <tr>
                <td>{this.props.searchResult.bookAuthorMap.book.isbn13}</td>
                <td>{this.props.searchResult.bookAuthorMap.book.title}</td>
                <td>{this.props.searchResult.bookAuthorMap.author.name}</td>
                <td>{this.props.searchResult.bookAuthorMap.book.publisher}</td>
                <td>{this.props.searchResult.bookAvailableForBorrowing}</td>
            </tr>
        )
    }
}


ReactDOM.render(
    <App />,
    document.getElementById('react')
)