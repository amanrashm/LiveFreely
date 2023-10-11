import React, { useState } from 'react';
import "./Indivisual_Register.css";
function Indivisual_Register() {
    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [error, setError] = useState('');

    const handleRegister = () => {
        // Check if passwords match
        if (password !== confirmPassword) {
            setError('Passwords do not match');
            return;
        }

        // Prepare registration data
        const registrationData = {
            username: username,
            email: email,
            password: password,
        };

        // Send the registration data to the backend API
        fetch('/auth/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(registrationData),
        })
            .then((response) => response.json())
            .then((data) => {
                if (data.error) {
                    setError(data.error);
                } else {
                    // Registration successful, you can handle it as needed
                    console.log('Registration successful:', data);
                }
            })
            .catch((error) => {
                console.error('Error during registration:', error);
                setError('Registration failed');
            });
    };

    return (
        <div className="container mt-5">
            <h1 className="mb-4">Individual Registration</h1>
            <div className="mb-3">
                <label htmlFor="username" className="form-label">
                    Username
                </label>
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
                <label htmlFor="email" className="form-label">
                    Email
                </label>
                <input
                    type="email"
                    className="form-control"
                    id="email"
                    placeholder="Enter email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
            </div>
            <div className="mb-3">
                <label htmlFor="password" className="form-label">
                    Password
                </label>
                <input
                    type="password"
                    className="form-control"
                    id="password"
                    placeholder="Enter password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
            </div>
            <div className="mb-3">
                <label htmlFor="confirmPassword" className="form-label">
                    Confirm Password
                </label>
                <input
                    type="password"
                    className="form-control"
                    id="confirmPassword"
                    placeholder="Confirm password"
                    value={confirmPassword}
                    onChange={(e) => setConfirmPassword(e.target.value)}
                />
            </div>
            <button className="btn btn-primary" onClick={handleRegister}>
                Register
            </button>
            {error && <p className="mt-3 text-danger">{error}</p>}
        </div>
    );
}

export default Indivisual_Register;
