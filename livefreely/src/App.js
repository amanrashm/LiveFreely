import React from 'react';
import { BrowserRouter as Router, Route, Redirect } from 'react-router-dom';
import Dashboard from './Pages/Dashboard_Livefreely/dashboard';
import CorporateLogin from './Pages/Corporate_Login/login';
import CorporateLogout from './Pages/Corporate_Logout/logout';
import IndividualLogin from './Pages/Indivisual_Login/login';
import IndividualLogout from './Pages/Indivisual_Logout/logout';
import CorporateRegister from './Pages/Corporate_Register/Corporate_Register';
import IndividualRegister from './Pages/Indivisual_Register/Indivisual_Register';
import SubscriptionPlans from './Pages/Subscription_plans/subscription_plans';

function App() {
    return (
        <Router>
            <Route path="/corporate/register" exact component={CorporateRegister} />
            <Route path="/individual/register" exact component={IndividualRegister} />
            <Route path="/corporate/login" exact component={CorporateLogin} />
            <Route path="/corporate/logout" exact component={CorporateLogout} />
            <Route path="/individual/login" exact component={IndividualLogin} />
            <Route path="/individual/logout" exact component={IndividualLogout} />
            <Route path="/subscription-plans" exact component={SubscriptionPlans} />

            {/* Default to Dashboard */}
            <Route path="/" exact component={Dashboard} />
        </Router>
    );
}

export default App;
