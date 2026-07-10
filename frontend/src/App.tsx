import {useState, useEffect} from "react"
import axios from 'axios'
import LoginForm from './LoginForm'

interface Agency {
  id: number
  name: string
  email: string
  phone: string
  address: string
  city: string
  country: string
  website: string
  active: boolean
  createdAt: string
}


function App() {
  const[agencies, setAgencies] = useState<Agency[]>([])
  const [token, setToken] = useState('')

  useEffect(() => {
    axios.get<Agency[]>('http://localhost:8080/api/agencies', {
      headers: {Authorization: `Bearer ${token}`}
    } )
        .then(response => setAgencies(response.data))
        .catch(err => console.log('Still failing:', err.response?.status))
  }, [token])

  return(
      <div>
        <h1>Empirium</h1>
          <LoginForm />
        <ul>
          {agencies.map(agency => (
              <li key={agency.id}>{agency.name}</li>
          ))}
        </ul>
      </div>
  )
}

export default App