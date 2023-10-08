import React, { useState } from 'react';

function Corporate_Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    const handleLogin = () => {
        // Create a login request object
        const loginRequest = {
            username: username,
            password: password
        };

        // Send the login request to the Spring Boot backend
        fetch("/auth/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(loginRequest)
        })
            .then(response => response.json())
            .then(data => {
                if (data.token) {
                    // Successful login
                    setError('');
                    console.log('Corporate user logged in');
                } else {
                    // Failed login
                    setError('Invalid username or password');
                }
            })
            .catch(error => {
                console.error("Error:", error);
                // Handle any errors during the login process
                setError('An error occurred during login');
            });
    };

    return (
        <div className="container mt-5">
            <div className="row justify-content-center">
                <div className="col-md-6">
                    <div className="card">
                        <div className="card-header">
                            <h2 className="text-center">Corporate Login</h2>
                        </div>
                        <div className="card-body">
                            <div className="mb-3">
                                <label htmlFor="username" className="form-label">Username</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    id="username"
                                    placeholder="Enter username"
                                    value={username}
                                    onChange={(e) => setUsername(e.target.value)}
                                />
                            </div>
                            <div className="mb-3">
                                <label htmlFor="password" className="form-label">Password</label>
                                <input
                                    type="password"
                                    className="form-control"
                                    id="password"
                                    placeholder="Enter password"
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                />
                            </div>
                            <button
                                type="button"
                                className="btn btn-primary btn-block"
                                onClick={handleLogin}
                            >
                                Login
                            </button>
                            {error && <p className="mt-3 text-danger">{error}</p>}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Corporate_Login;