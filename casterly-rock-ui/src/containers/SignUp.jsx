import React, { Component } from 'react';

import { connect } from "react-redux";
import { signIn } from "../actions/actions";
import { withRouter } from 'react-router-dom';


class SignUp extends Component {
    constructor(props) {
        super(props);

        this.state = {
            email: '',
            password: '',
            error: '',
        }
    }

    handleSubmit(event) {
        event.preventDefault();
        const {email, password} = this.state;
        this.props.signIn(email, password, () => {
            this.props.history.push(`/profile`);
        }, (message) => {
            this.setState({
                error: message
            });
        });
    }

    handleInputChange(event) {
        const value = event.target.value;
        const key = event.target.name;

        this.setState({
            [key]: value
        });
    }

    render() {
        const { error } = this.state;
        return (
            <div>
                <form className="sign-up-form mx-auto my-5" onSubmit={this.handleSubmit.bind(this)}>
                    <div className="form-group">
                        <label htmlFor="sign-up-firstName">First name</label>
                        <input type="text" className="form-control" id="sign-up-firstName"
                               placeholder="First name" name="firstName" onChange={this.handleInputChange.bind(this)}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="sign-up-lastName">Last name</label>
                        <input type="text" className="form-control" id="sign-up-lastName"
                               placeholder="Last name" name="lastName" onChange={this.handleInputChange.bind(this)}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="sign-up-email">Email address</label>
                        <input type="email" className="form-control" id="sign-up-email" placeholder="Enter email" name="email"
                               onChange={this.handleInputChange.bind(this)}/>
                    </div>
                    <div className="form-group">
                        <label htmlFor="sign-up-password">Password</label>
                        <input type="password" className="form-control" id="sign-up-password"
                               placeholder="Password" name="password" onChange={this.handleInputChange.bind(this)}/>
                    </div>
                    <span className="text-danger d-block">{error}</span>
                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        )
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        signIn: (email, password, onSuccess, onError) => {
            dispatch(signIn(email, password, onSuccess, onError));
        }
    }
};

export default withRouter(connect(null, mapDispatchToProps)(SignUp));