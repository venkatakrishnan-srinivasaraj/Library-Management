import React from 'react';
import ReactDOM from 'react-dom';
import SearchResults from './SearchResults'
import CheckinSearchResult from './CheckinSearchResult';

class CheckinSearch extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            searchString : "",
            searchResults: []
        };
        this.handleChange = this.handleChange.bind(this);
    }
  
    handleChange(e) {
        e.preventDefault();
        var newSearchString = document.getElementById("search").value;
        console.log(newSearchString)
        if(newSearchString.trim() === ""){
            this.setState({
                searchString: "",
                searchResults : []
            });
        }else{
            fetch(`http://localhost:8080/book/checkin/search/`+newSearchString)
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
      this.setState({
        searchString : "",
        searchResults : []
      });  
    }
  
    render() {
        return (
            <div>
                <h1>Library Management System</h1>
                <h2>Checkin Portal</h2>
                <div>
                  <form>
                    <input id="search" type="text" placeholder="type here to search" />
                    <button onClick={this.handleChange}>Search</button>
                    <hr />
                  </form>
                </div>
                <CheckinSearchResults searchResults={this.state.searchResults}/>
            </div>
    )
    }

}
export default CheckinSearch;