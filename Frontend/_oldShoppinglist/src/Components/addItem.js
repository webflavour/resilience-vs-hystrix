import React from 'react';
import { FormGroup, FormControl, Button, InputGroup } from 'react-bootstrap';

export default class AddItem extends React.Component {

  constructor(props, context) {
    super(props, context);
    this.handleChange = this.handleChange.bind(this);
    this.onEnter = this.onEnter.bind(this);
    this.state = {
      value: ''
    };
  }

  handleChange(e) {
    this.setState({ value: e.target.value });
  }

  resetInputValue() {
    this.setState({ value: '' });
  }

  onEnter(e) {
    if (e.key === 'Enter') {
      this.props.onClick(this.state.value);
      this.resetInputValue();
    }
  }

  render() {
    return (
        <FormGroup>
          <InputGroup>
            <FormControl
                type="text"
                value={this.state.value}
                onChange={this.handleChange}
                onKeyPress={this.onEnter}
                placeholder="Füge der Liste etwas hinzu"
            />
            <InputGroup.Addon>
              <Button
                  bsStyle="success"
                  type="button"
                  onClick={() => {
                    this.props.onClick(this.state.value);
                    this.resetInputValue();
                  }}
              >
                Add Item
              </Button>
            </InputGroup.Addon>
          </InputGroup>
        </FormGroup>
    );
  }
}
