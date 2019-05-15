import React, { Component } from 'react';
import App from './App';
import SignIn from './SignIn';
import SignUp from './containers/SignUp';
import Header from './Header';
import Profile from './containers/Profile'

import { Route, Switch } from 'react-router-dom';

class Router extends Component {
    render() {
        return (
            <div>
                <Header/>
                <Switch>
                    <Route path="/signin" component={SignIn}/>
                    <Route path="/signup" component={SignUp}/>
                    <Route path="/profile" component={Profile}/>
                    <Route path="/" component={App}/>
                </Switch>
            </div>
        )
    }
}

export default Router;