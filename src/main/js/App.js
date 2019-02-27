import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Search from './Search'
import BorrowerManagement from './BorrowerManagement'
import Checkin from './Checkin'
import Fine from './Fine'
// import '../resources/static/App.css';
// const React = require('react');
// const ReactDOM = require('react-dom');

class App extends React.Component {
    render() {
        return (
            <Router>
              <Switch>
                <Route path='/' exact={true} component={Search}/>
                <Route path='/borrowerManagement' exact={true} component={BorrowerManagement}/>
                <Route path='/checkin' exact={true} component={Checkin}/>
                <Route path='/fine' exact={true} component={Fine}/>
              </Switch>
            </Router>
        )
      }
}

ReactDOM.render(<App />, document.getElementById('react'));


export default App;