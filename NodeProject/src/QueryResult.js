import React from "react";
import { Table } from "react-bootstrap";
import { Collapse } from "react-bootstrap";
import { Container } from "react-bootstrap";

class QueryResult extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      open: props.open
    };
  }

  render() {
    const { open } = this.state;
    return (
      <Container>
        <h4 onClick={() => this.setState({ open: !open })}>
          {this.props.value.Query}
        </h4>
        <Collapse in={this.state.open}>
        { this.props.value.IsBoolean ?
          (<div>
            {this.props.value.BooleanResult ? 'True' : 'False'}
          </div>) : 
          (this.props.value.Results.length == 0 ? (
            <div>Ø</div>
          ):(<div>
            <Table striped bordered hover>
              <thead>
                <tr>
                  {this.props.value.VariableBindings.map(variable => (
                    <th key={variable}>{variable.substring(1)}</th>
                  ))}
                </tr>
              </thead>
              <tbody>
                {this.props.value.Results.map(result => (
                  <tr>
                    {result.map(constant => (
                      <td>{constant.slice(0, -1).substring(1)}</td>
                    ))}
                  </tr>
                ))}
              </tbody>
            </Table>
          </div>))
          }
        </Collapse>
      </Container>
    );
  }
}

export function Results(props) {
  return (
    <ul>
      {props.visible &&
        props.data.map((queryResult, index) => (
          <QueryResult
            key={queryResult.Query}
            value={queryResult}
            open={index == 0}
          />
        ))}
    </ul>
  );
}