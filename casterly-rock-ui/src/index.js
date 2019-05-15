import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from "react-router-dom";
import Router from './Router'
import './index.css'

import { createStore, applyMiddleware} from "redux";
import Reducers from './reducers/reducers';
import { Provider } from 'react-redux';
import thunkMiddleware from 'redux-thunk';
import { createLogger } from "redux-logger";

const store = createStore(
    Reducers,
    applyMiddleware(thunkMiddleware, createLogger())
);

ReactDOM.render(
    <Provider store={store}>
        <BrowserRouter>
            <Router/>
        </BrowserRouter>
    </Provider>,
    document.getElementById('root'));