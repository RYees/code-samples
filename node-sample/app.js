'use strict';

// Load the environment variables
require('dotenv').config();
require('./config');

// Initialize app components
const app           = require('express')();
const bodyParser    = require('body-parser');
const port          = process.env.PORT;
const env           = process.env.NODE_ENV;
const baseUrl       = process.env.BASE_URL + '/' + process.env.VERSION;

const bearerToken   = require('express-bearer-token');
const validator     = require('express-validator');

const Log = require('./util/log');
new Log(app);
const log = Log;

// Setup the app middlewares
app.use(bodyParser.json());
app.use(validator());
app.use(bearerToken());

app.use(baseUrl, require('./routes'));

// Start the Node server
app.listen(port, () => log.i(`API running in [${env}] on port ${port}`));

module.exports = app;