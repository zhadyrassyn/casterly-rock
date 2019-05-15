import React, { Component } from 'react';
import App from './App';
import SignIn from './SignIn';
import Header from './Header';

import { Route, Switch } from 'react-router-dom';

class Router extends Component {
    render() {
        return (
            <div>
                <Header/>
                <Switch>
                    <Route path="/signin" component={SignIn}/>
                    <Route path="/" component={App}/>
                </Switch>
            </div>
        )
    }
}

export default Router;