import React from 'react';
import ReactDOM from 'react-dom';
// import '../resources/static/index.css';
import App from './App';
import BorrowerManagement from './BorrowerManagement';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(<App />, document.getElementById('react'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
