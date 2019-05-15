import {
    SIGN_IN_SUCCESS,
    SIGN_IN_ERROR
} from "../types/types";

import axios from 'axios';

export const signIn = (email, password, onSuccess, onError) => (dispatch) => {
    axios.post('http://localhost:8080/api/auth/signin', {
        email,
        password
    }).then(({data}) => {
        localStorage.setItem('token', data.token);
        dispatch({
            type: SIGN_IN_SUCCESS
        });
        onSuccess();
    }).catch((error) => {
        console.log(error);
        dispatch({
            type: SIGN_IN_ERROR
        });
        if (error.response.status === 401) {
            onError('Username or password is wrong');
        } else {
            onError('Internal Server Error');
        }
    });
};