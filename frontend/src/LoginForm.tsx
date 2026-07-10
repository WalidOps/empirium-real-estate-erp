import {useState} from "react"
import axios from "axios";

function LoginForm() {
    const[email, setEmail] = useState('')
    const[password, setPassword] = useState('')
    const[token, setToken] = useState('')

    const handleSubmit =(e: React.FormEvent) => {
        e.preventDefault()
        axios.post('http://localhost:8080/api/auth/authenticate', {email: email, password: password})
            .then(response => {
                setToken(response.data.token)
            })
    }
    return (
        <div>
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
            <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />
            <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />
                <button type={"submit"}>Log In</button>
            </form>
            {token && <p>Logged in! Token: {token.substring(0, 20)}...</p>}
        </div>
    )
}

export default LoginForm
