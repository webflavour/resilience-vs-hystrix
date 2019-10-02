import React from 'react';
// import {api} from '../../Core/api';

import './Dashboard.css';


class Dashboard extends React.Component {

    constructor(props) {

        super(props);

        this.state = ({


           test: null,

        });

    }

    componentWillMount() {

        this.fetchData();

       //  api.getClient().then(data => {
         //   this.setState({test});
        // });

    }




    fetchData() {

      // API connection

    }

    render() {

        return (
            <div >
                <header>
                  Hello
                </header>
                <main>

                </main>
                <footer>

                </footer>
            </div>
        );

    }

}

export default Dashboard;
