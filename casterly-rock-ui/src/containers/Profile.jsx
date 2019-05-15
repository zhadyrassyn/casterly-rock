import React, { Component } from 'react';

import { connect } from "react-redux";


class Profile extends Component {
    constructor(props) {
        super(props);
    }
    
    render() {
        return (
            <div>
                Profile Page
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {}
};

// const mapDispatchToProps = (dispatch) => {
//    
// }

export default connect(null, null)(Profile);